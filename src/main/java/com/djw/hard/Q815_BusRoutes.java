package com.djw.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * @Author: dai jiawei
 * @Date: 2021/6/28 16:45
 */
public class Q815_BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        //获取每个站点的途径的公交车
        Map<Integer, List<Integer>> routeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < routes.length ; i++) {
            for (int j = 0; j <routes[i].length ; j++) {
                if(routeMap.containsKey(routes[i][j])){
                    List<Integer> s= routeMap.get(routes[i][j]);
                    s.add(i);
                    routeMap.put(routes[i][j],s);
                }else{
                    List<Integer> s = new ArrayList<Integer>();
                    s.add(i);
                    routeMap.put(routes[i][j],s);
                }
            }
        }

        busesToDestination(routeMap,routes,source,target);
        return -1;
    }

    private int busesToDestination(Map<Integer, List<Integer>> routeMap, int[][] routes, int source, int target) {
        if(routeMap.size()==0){
            return -1;
        }
        List<Integer> xl =routeMap.get(source);
        routeMap.remove(source);
        for (Integer x :xl) {
            //经过这个车站的所有公交车
            for (int i = 0; i <routes[x].length ; i++) {
                //查询公交车经过哪些站
                int y = routes[x][i];
                if(y==target){
                    return 1;
                }else if(y!=source){
                    int m = busesToDestination(routeMap,routes,source,target);
                    return -1;
                }
            }
        }
        return -1;
    }
}
