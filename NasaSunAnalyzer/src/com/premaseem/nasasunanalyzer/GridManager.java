package com.premaseem.nasasunanalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajain
 */
public class GridManager {

    private Integer grid[][];
    private Integer gridSize;
    private List<ResultCell> sortList = new ArrayList<ResultCell>();

    // constructor used for problem 1
    public GridManager(int i) {
        gridSize = i;
//        grid = new Integer[gridSize][gridSize];
    }

    public GridManager() {
    }

    public Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Integer[][] createGrid() {
        return grid = new Integer[gridSize][gridSize];
    }

    public String parseInput(String gridInputFile) {

        String gridInfo = "";
        try {
            Scanner scanner = new Scanner(new File(gridInputFile));
            gridInfo = scanner.nextLine();
            System.out.println("gridInfo = " + gridInfo);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GridManager.class.getName()).log(Level.SEVERE, "Sorry File doesnot exists ", ex);
        }
        return gridInfo.trim();

    }

    public void populateGrid(String gridInfoStream) {
        String[] gridInputData = gridInfoStream.split(" ");
        Integer cellLocation = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                grid[row][column] = Integer.parseInt(gridInputData[cellLocation++]);
            }
        }
        System.out.println(" ========== Printing Input Grid ===============");
        printGrid(grid);

    }

    public int calculateGridScoreForCell(int x, int y) {
        Integer score = 0;
        for (int row = determineStart(x); row <= determineEnd(x); row++) {
            for (int column = determineStart(y); column <= determineEnd(y); column++) {
                score += this.grid[row][column];
//                System.out.println("score = " + score);
//                sortList.add(new ResultCell(column-1, row-1, score));
            }
        }
        return score;
    }

    private int determineStart(int location) {
        return (location - 1 >= 0) ? location - 1 : location;
    }

    private int determineEnd(int location) {
        return location + 1 <= (gridSize - 1) ? location + 1 : location;
    }

    public void printGrid(Integer[][] gridObj) {

        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                System.out.print(" " + gridObj[row][column]);
            }
            System.out.println("");
        }
    }

    public void printScoreReport() {
        System.out.println("=============== Printing Result Grid =====================");
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                Integer cellScore = calculateGridScoreForCell(row, column);
                sortList.add(new ResultCell(column, row, cellScore));
                System.out.print(" " + cellScore);

            }
            System.out.println("");
        }
    }

    public void printTopResults(int num) {
        Collections.sort(sortList);
        for (int i = 0; i < num; i++) {
            System.out.println(sortList.get(i));
        }


    }

    public List<ResultCell> getSortList() {
        Collections.sort(sortList);
        return sortList;
    }

    public int extractFirstNumber(String dataStream) {
        String split[] = dataStream.split(" ");
        return Integer.parseInt(split[0].trim());
    }
}
