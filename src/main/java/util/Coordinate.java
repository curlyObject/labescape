package util;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Coordinate implements Cloneable{

    private final int x;
    private final int y;

    public Coordinate moveUp(){
        return new Coordinate(this.x, this.y-1);
    }

    public Coordinate moveRight(){
        return new Coordinate(this.x+1, this.y);
    }

    public Coordinate moveDown(){
        return new Coordinate(this.x, this.y+1);
    }

    public Coordinate moveLeft(){
        return new Coordinate(this.x-1, this.y);
    }

    public Coordinate deepClone(){
        return new Coordinate(this.x, this.y);
    }

}
