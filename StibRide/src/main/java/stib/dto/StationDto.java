/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.dto;

/**
 *
 * @author nadou
 */
    public class StationDto extends Dto<Integer>{
    
    private String name;

    public StationDto(Integer key, String name) {
        super(key);
        this.name = name;
    }

    public String getStationName() {
        return name;
    }

    @Override
    public String toString() {
        return "name= " + name +  " id= "+ super.key;
    }
    
    
}
