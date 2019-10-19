package uk.reading.ac.uk.spink.drone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

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

    public void main(String[] args) {
        DroneArena d = new DroneArena(10,20);
        d.addDrone();
        d.addDrone();

        objectToJson(d);
    }
}
