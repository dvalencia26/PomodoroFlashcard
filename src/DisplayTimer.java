public class DisplayTimer implements Observer {
    @Override
    public void update(int currentTime) {
        int minutes = currentTime / 60;
        int seconds = currentTime % 60;
        System.out.println("Time Remaining: " + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
    }
}
