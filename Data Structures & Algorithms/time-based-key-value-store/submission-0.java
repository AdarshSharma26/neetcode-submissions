class Pair{
    String mood;
    int timestamp;

    public Pair(String mood, int timestamp){
        this.mood = mood;
        this.timestamp = timestamp;
    }
}

class TimeMap {
      
    Map<String,List<Pair>> hashMap;  


    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        Pair pair = new Pair(value,timestamp);
        
        if(!hashMap.containsKey(key)){
            List<Pair> ls = new ArrayList<>();
            ls.add(pair);
            hashMap.put(key, ls);
        }else{
            List<Pair> temp = hashMap.get(key);
            temp.add(pair);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)) return "";

        String result = "";
        List<Pair> temp = hashMap.get(key);
        
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).timestamp <= timestamp){
                result = temp.get(i).mood;
            }
        }

        return result;
    }
}
