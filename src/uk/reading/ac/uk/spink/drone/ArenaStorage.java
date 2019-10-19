package uk.reading.ac.uk.spink.drone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ArenaStorage {

    public void objectToJson(DroneArena d){
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
                continue;
            }
            obj.put("Drones",arr);
        }
        System.out.println(obj.toJSONString());
    }

    public void main(String[] args) {
        DroneArena d = new DroneArena(10,20);
        d.addDrone();
        d.addDrone();

        objectToJson(d);
    }
}
