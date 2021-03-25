
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;

    public int getAssists() {
        return assists;
    }

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name + "\t" + "team: " + team + "\t" + " goals: " + goals + "\t" + " assists: " + assists + "\t" + "sum: " + (goals + assists);
    }
    
    @Override
    public int compareTo(Player other) {
        return (other.getGoals() + other.getAssists()) - (this.goals + this.assists);
    }
}
