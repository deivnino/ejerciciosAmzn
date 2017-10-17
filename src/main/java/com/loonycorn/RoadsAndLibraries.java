/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loonycorn;

/**
 *
 * @author dnino
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsAndLibraries {
    
    private static ArrayList<Integer>[] adjCities;
    private static int connectedComponents;
    private static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); // number of queries
        for(int a0 = 0; a0 < q; a0++){
            int cities = in.nextInt(); // number of cities
            //System.out.println("Total number of cities: "+cities);
            int roads = in.nextInt(); // number of roads
            //System.out.println("Total number of bidirectional roads: "+roads);
            int libCost = in.nextInt(); // cost of building a library
            //System.out.println("Cost of building library: "+libCost);
            int roadCost = in.nextInt(); // cost of repairing a road
            //System.out.println("Cost of repairing road: "+roadCost);

            /**
             * Input Format
             * 
             * The first line contains a single integer, , denoting the number
             * of queries. The subsequent lines describe each query in the
             * following format:
             * 
             * The first line contains four space-separated integers describing
             * the respective values of (the number of cities), (the number of
             * roads), (the cost to build a library), and (the cost to repair a
             * road). Each line of the subsequent lines contains two
             * space-separated integers, and , describing a bidirectional road
             * connecting cities and .
             * 
             * Sample Input
             * 
             *	2
             *	3 3 2 1
             *	1 2
             *	3 1
             *	2 3
             *	6 6 2 5
             *	1 3
             *	3 4
             *	2 4
             *	1 2
             *	2 3
             *	5 6
             *	
             *	Sample Output
             *	
             *	4
             *	12
             * 
             **/
            
            
            if (roadCost >= libCost || roads == 0){ 
                // optimal scenario/edge (corner) case + a for loop to get correct nextInts
                System.out.println(libCost * cities);
                for (int i = 0; i < (roads*2); i++){
                    in.nextInt();
                }
                continue;
            }
            
            
            else{
                //Now we must try to get all the connected components
                
                adjCities = (ArrayList<Integer>[]) new ArrayList[cities+1];
                for (int c = 0; c <= cities; c++) {
                    adjCities[c] = new ArrayList<Integer>();
                }
                
                visited = new boolean[cities+1];
                
                //initializing adjCities
                for (int i = 0; i < roads; i++){
                    int c1 = in.nextInt();
                    int c2 = in.nextInt();
                    
                    adjCities[c1].add(c2);
                    adjCities[c2].add(c1);
                }
                
                //System.out.println(adjCities.length);
                
                //Checking our adjCities
                /*for (int i = 0; i < roads; i++){
                    System.out.println(adjCities[i]);
                    //for (int index = 0; index < adjCities[i].size(); index++)
                        //System.out.println(adjCities[i].get(index));
                }*/
                    
                //System.out.println(adjCities[1].size());
                //System.out.println(adjCities[1].get(1));
                
                
                //Boolean arrays are initialized to false in Java automatically
                /*for (int i = 0; i <= cities; i++){
                    visited[i] = false;
                }*/
                
                for(int c = 1; c <= cities; c++) {
                    if(!visited[c]) {
                        dfs(c);
                        connectedComponents++;
                    }
                }
           
                //System.out.println(connectedComponents);
                System.out.println(roadCost * (cities - connectedComponents) + libCost * connectedComponents);
                connectedComponents = 0;
                visited = new boolean[10000];
                adjCities = (ArrayList<Integer>[]) new ArrayList[10000+1];
            }
        }
    }
    
    private static void dfs(int city){
        visited[city] = true;
        //System.out.println("visited[city] = true: "+city);
        //System.out.println("adjCities[city].size(): "+adjCities[city].size());
        //System.out.println(adjCities[2].get(0));
        //System.out.println(adjCities[2].get(1));
        for (int c = 0; c < adjCities[city].size(); c++){
            if(!visited[adjCities[city].get(c)]){
                //System.out.println("visiting adjCities[city.get(c)]: "+ adjCities[city].get(c));
                dfs(adjCities[city].get(c));
            }
        }
    }
    
}
