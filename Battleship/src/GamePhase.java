public enum GamePhase {
    PLACING,
    BATTLING,
    END;

    public boolean equals(GamePhase other) {
        if (this.equals(other)) {
            return true;
        }
        return false;
    }
}
