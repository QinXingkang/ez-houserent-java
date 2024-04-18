package ProjectExercise.houserent.service;



import ProjectExercise.houserent.domain.House;

import java.util.Scanner;

/*
 * @date
 * @content
 */
public class HouseService {
    private House[] houses;
    private int houseNums;//记录当前又多少个房屋信息

    private int idcounter = 0;//记录当前的id自增长

    public HouseService(int size){
        houses = new House[size];
        //创建HouseService对象，指定数组大小
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newhouse){
        //先判断是否可以继续添加（我们暂时不考虑数组扩容的问题）
        if(houseNums >= houses.length){
            System.out.println("数组已满，不能再添加");
            return false;
        }

        houses[houseNums++] = newhouse;
        //新增了一个房屋
        //需要设计一个id自增长的机制,然后更新newHouse的id
        newhouse.setId(++idcounter);
        return true;
    }

    public House findById(int findId){
        //遍历数组
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
    public boolean del(int delId){
        //应当先找到要删除房屋的信息对应的下标
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()){
                index = i;//用index记录要删除房屋信息的下标
            }
        }
        if(index == -1){
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;//将当前存在的房屋信息的最后一个信息置空
        return true;
    }

    public House[] list(){
        return houses;
    }
}
