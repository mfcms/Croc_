package karma.lab7.task13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import karma.lab7.task13.AuctionLot;

public class Task13 {
    public static void main(String[] args) {
        AuctionLot auctionLot = createAuctionLotFromInputFiles("lot.txt");
        String[] participants = readParticipantsFromFile("participants.txt");

        for (String participant : participants) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    int bidPrice = generateRandomBid(auctionLot.getCurrentBidAmount());
                    auctionLot.bid(bidPrice, participant);
                    try {
                        Thread.sleep(10); // для демонстрационных целей добавим небольшую задержку между ставками
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }

        try {
            // Ждем, пока все потоки завершатся перед выводом победителя
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Победитель аукциона: " + auctionLot.getWinningUserName()
                + ", ставка: " + auctionLot.getCurrentBidAmount());
    }

    private static AuctionLot createAuctionLotFromInputFiles(String lotFilePath) {
        AuctionLot auctionLot = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(lotFilePath))) {
            String lotName = reader.readLine();
            int initialPrice = Integer.parseInt(reader.readLine());
            long endTime = System.currentTimeMillis() + 60000; // 60 секунд для демонстрационных целей, можно изменить

            auctionLot = new AuctionLot(initialPrice, endTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return auctionLot;
    }

    private static String[] readParticipantsFromFile(String participantsFilePath) {
        StringBuilder participantsBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(participantsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participantsBuilder.append(line).append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String participantsString = participantsBuilder.toString().trim();
        return participantsString.split(",");
    }

    private static int generateRandomBid(int currentBid) {
        // Генерируем случайную ставку, большую чем текущая ставка
        return currentBid + (int) (Math.random() * 100);
    }
}
