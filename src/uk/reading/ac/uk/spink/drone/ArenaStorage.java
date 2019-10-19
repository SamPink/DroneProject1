package uk.reading.ac.uk.spink.drone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

public class ArenaStorage {

    public JSONObject objectToJson(DroneArena d){
        JSONObject obj = new JSONObject();
        obj.put("areaX", d.getSizeX());
        obj.put("areaY", d.getSizeY());

        JSONArray arr = new JSONArray();
        for (int i = 0; i < d.drones.size(); i++) {
            JSONObject droneObj = new JSONObject();
            try{
                Drone tmpDrone = d.drones.get(i);
                droneObj.put("id", tmpDrone.ID);
                droneObj.put("xPos", tmpDrone.positionX);
                droneObj.put("yPos", tmpDrone.positionY);
                droneObj.put("direction", tmpDrone.direction.toString());

                arr.add(i, droneObj);
            }catch (Exception ex){
                ex.printStackTrace();
                return null;
            }
            obj.put("Drones",arr);
        }
        return obj;
    }

    public DroneArena JsonToObject(JSONObject jo){
        DroneArena d1;
        try{
            int x = (int) jo.get("areaX");
            int y = (int) jo.get("areaY");
            d1 = new DroneArena(x,y);
            JSONArray drones = (JSONArray) jo.get("Drones");
            for (int i = 0; i <drones.size() ; i++) {
                JSONObject droneObj = (JSONObject) drones.get(i);
                int droneId = (int)droneObj.get("id");
                int xPos = (int)droneObj.get("xPos");
                int yPos = (int)droneObj.get("yPos");
                //TODo import the Enum direction into the class (get it to cast)
                //Direction dir = (Direction) droneObj.get("direction");

                d1.addDrone(xPos, yPos);

                if(d1.drones.get(i).ID != droneId){
                    throw new Exception("Failed to add drone");
                }else{
                    //TODo once imported put it in drone object
                }
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return d1;
    }

    public void writeToFile(JSONObject js, String fileName){
        try{
            fileName+=".txt";
            FileWriter f = new FileWriter(fileName);
            f.write(js.toJSONString());
            f.flush();
            System.out.println(f.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject readFromFile(String file){
        //ToDO import txt file
        JSONObject jo = new  JSONObject();

        return jo;
    }

    public void main(String[] args) {
        DroneArena d = new DroneArena(10,20);
        d.addDrone();
        d.addDrone();

        objectToJson(d);
    }
}
