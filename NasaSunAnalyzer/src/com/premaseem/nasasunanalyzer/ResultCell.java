/*
 * This domain object holds the value score and coordinates of Result Cell
 */
package com.premaseem.nasasunanalyzer;

/**
 *
 * @author ajain
 */
public class ResultCell implements Comparable<ResultCell> {

    private Integer x, y, score;

    public int getScore() {
        return score;
    }

    public ResultCell(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + " score:" + score + ')';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        hash = 79 * hash + this.y;
        hash = 79 * hash + this.score;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultCell other = (ResultCell) obj;
        return true;
    }

    @Override
    public int compareTo(ResultCell o) {
        return o.score.compareTo(score);
    }
}
