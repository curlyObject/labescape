package main.util;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.stream.Stream;

/**
 * Linked list of coordinates exposing only the needed linked list methods
 */
// Lombok annotations can sometimes cause issues with some IDEs, it requires annotation pre-processing to be enabled.
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Path implements Cloneable{

    private LinkedHashSet<Coordinate> path = new LinkedHashSet<>();
    private @Getter @Setter boolean providesEscape = false;

    /**
     * Append the coordinate to the end of the list if it doesn't already contain the
     * @param coordinate X & Y coordinate in the maze
     */
    public boolean addCoordinate(Coordinate coordinate){
        return path.add(coordinate);
    }

    /**
     * Checks if the coordinate is already in the maze
     * @param coordinate
     */
    public boolean containsCoordinate(Coordinate coordinate){
        return path.contains(coordinate);
    }

    public int getNumberOfSteps(){ return path.size();}

    public Stream<Coordinate> coordinateStream(){
        return path.stream();
    }

    public Path deepClone(){
        Path path = new Path();
        this.coordinateStream().forEach(coordinate -> path.addCoordinate(coordinate.deepClone()));
        return path;
    }

}
