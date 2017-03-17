package util;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.stream.Stream;

/**
 * Linked list of coordinates exposing only the needed linked list methods
 */
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Path {

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

    public Stream<Coordinate> coordinateStream(){
        return path.stream();
    }

}