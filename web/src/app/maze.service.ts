import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { MazeBlock } from './MazeBlock';

@Injectable()
export class MazeService {

  constructor(private http: Http) { }

  solveMaze(maze: MazeBlock[][], startX: number, startY: number): Promise<MazeBlock[][]> {
    // const url = "http://localhost:8080/api/maze/solve?maze=O%20OOO%20%20OOO%20OOOOO&mazeWidth=4&startX=2&startY=1";
    const url = `http://localhost:8080/api/maze/solve?maze=${this.convertMazeToString(maze)}&mazeWidth=${maze[0].length}&startX=${startX}&startY=${startY}`;
    console.log(`Url ${url}`);
    return this.http.get(url)
      .toPromise()
      .then(response => {
        let mazeString = response.text() as String;
        let i: number = 0;
        let solvedMaze : MazeBlock[][] = [];
        let mazeRows: string[] = mazeString.split("\n");

        for (i; i < maze.length; i++){
          solvedMaze[i] = [];
          let j: number = 0;
          for (j; j < maze[i].length; j++){
            solvedMaze[i][j] = new MazeBlock(mazeRows[i][j]);
          }
        }
        console.log(solvedMaze);
        return solvedMaze;
      })
      .catch(this.handleError);
}

private convertMazeToString(maze: MazeBlock[][] ): string{
    let mazeString: string = "";
    maze.forEach(row => row.forEach(block => mazeString += block.toString()));
    return mazeString;
}

private handleError(error: any): Promise<any> {
  console.error('An error occurred', error);
  return Promise.reject(error.message || error);
}

}
