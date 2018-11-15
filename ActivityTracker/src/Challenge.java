package ActivityTracker.src;

public class Challenge {
    String challenge1;
    String challenge2;
    String challenge3;

    public Challenge(String chall1, String chall2, String chall3) {
        this.challenge1 = chall1;
        this.challenge2 = chall2;
        this.challenge3 = chall3;
    }

    public void getChallenges() {
        System.out.println("Your challenges are this week are:\n" + this.challenge1 + "\n" + this.challenge2 + "\n"
                + this.challenge3);
    }

    public void setChallenge(String newChall1, String newChall2, String newChall3) {
        this.challenge1 = newChall1;
        this.challenge2 = newChall2;
        this.challenge3 = newChall3;
    }
}
