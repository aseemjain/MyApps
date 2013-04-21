/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.premaseem.nasasunanalyzer;

import java.util.List;

/**
 *
 * @author ajain
 */
public class GridDirector {
    
    private String fileName="";
    
    public GridDirector(String fileName){
    this.fileName=fileName;
    }
    
    public List<ResultCell> manageGrid(){
    
        GridManager gridManager = new GridManager();
        String dataStream = gridManager.parseInput(fileName).trim();
        
        Integer topResult = gridManager.extractFirstNumber(dataStream);
        dataStream = dataStream.substring(2, dataStream.length());
        
        Integer gridSize = gridManager.extractFirstNumber(dataStream);
        dataStream = dataStream.substring(2, dataStream.length());
    
        gridManager.setGridSize(gridSize);
        final Integer[][] grid = gridManager.createGrid();
        
        gridManager.populateGrid(dataStream);
        
        gridManager.printScoreReport();
        
        return gridManager.getSortList();   
    }
 
    
}
