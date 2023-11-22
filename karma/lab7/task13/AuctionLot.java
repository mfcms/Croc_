package karma.lab7.task13;
import java.util.concurrent.locks.ReentrantLock;

public class AuctionLot {
        private int currentPrice;
        private String winningUserName;
        private long endTime;
        private ReentrantLock lock;
    
        public AuctionLot(int initialPrice, long endTime) {
            this.currentPrice = initialPrice;
            this.endTime = endTime;
            this.lock = new ReentrantLock();
        }
    
        public void bid(int price, String bidderName) {//метод для ставки
            lock.lock();
            try {
                if (System.currentTimeMillis() < endTime && price > currentPrice) {
                    currentPrice = price;
                    winningUserName = bidderName;
                }
            } finally {
                lock.unlock();
            }
        }
    
        public int getCurrentBidAmount() {
            lock.lock();
            try {
                return currentPrice;
            } finally {
                lock.unlock();
            }
        }
    
        public String getWinningUserName() {
            lock.lock();
            try {
                return winningUserName;
            } finally {
                lock.unlock();
            }
        }
    }
