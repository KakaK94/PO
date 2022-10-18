package agh.ics.oop;

public class Vector2d {
    public final int x;

    public final int y;

    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int other_object;

    public Vector2d(int other_object){
        this.other_object=other_object;
    }

    public String toString(){
        return "(%d, %d)".formatted(x,y);
}

//nie wiedziałam, który obiekt ma być tym "akceptowanym innym obiektem tej klasy"


    public boolean precedes(Vector2d other){
    x=other.x;
y=other.y;
other_object = other.other_object;
        if(x<=other_object & y<=other_object)
      return true;
        else
            return false;
}

public boolean follows(Vector2d other) {
    x = other.x;
    y = other.y;
    other_object = other.other_object;
    if (x >= other_object & y >= other_object) {
        return true;
    } else {
        return true;
    }
}

public Vector2d adpublic Vector2d substract(Vector2d other){
        return new Vector2d(x:x - other.x, y:y - other.y);
    }d(Vector2d other){
        return new Vector2d(x:x + other.x, y:y + other.y);
}



    public enum MoveDirection {
        FORWARD, BACKWARD, RIGHT, LEFT
    }

     enum MapDirection {
         NORTH, SOUTH, WEST, EAST
     }
        public String toString(String MapDirection){
            switch(Vector2d.MapDirection){
                case NORTH:
                    System.out.println("Północ");
                    break;
                case SOUTH:
                    System.out.println("Połudnnie");
                    break;
                case WEST:
                    System.out.println("Zachód");
                    break;
                case EAST:
                    System.out.println("Wschód")
                    break;
            }

        public String next(String MapDirection){
           switch(Vector2d.MapDirection){
                    case NORTH:
                        System.out.println("SOUTH");
                        break;
                    case SOUTH:
                        System.out.println("WEST");
                        break;
                    case WEST:
                        System.out.println("NORTH");
                        break;
                    case EAST:
                        System.out.println("SOUTH")
                        break;
                }
                   }


            public String previous(String MapDirection){
                switch(Vector2d.MapDirection){
                    case NORTH:
                        System.out.println("WEST");
                        break;
                    case SOUTH:
                        System.out.println("EAST");
                        break;
                    case WEST:
                        System.out.println("SOUTH");
                        break;
                    case EAST:
                        System.out.println("NORTH")
                        break;
                }
            }

/*
public static void main(String[] args){
        Vector2d v1 = new Vector2d(x:2,y:5);

}
*/

}
