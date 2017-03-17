import { Component } from '@angular/core';

export class MazeBlock {
  xPosition: number;
  yPosition: number;
  type: string;

  constructor() {
    this.type = "O";
  }

}

@Component({
  selector: 'maze-builder',
  templateUrl: `/app/MazeBuilder.html`,
})
export class MazeBuilderComponent  {
  mazeWidth = 4;
  mazeHeight = 4;

  maze: MazeBlock[][] = [];

  updateMazeSize(mazeHeight, mazeWidth): void {
    console.log(`changing maze size...`);
    let i: number = 0;
    console.log(i);
    console.log(mazeHeight);
    let j: number = 0;
    console.log(j);
    console.log(mazeWidth);
    for (i; i < mazeHeight; i++){
      console.log(`First loop`);
      if (!this.maze[i]){
        this.maze[i] = [];
      }
      for (j; j < mazeWidth; j++){
        if (!this.maze[i][j]){
          this.maze[i][j] = new MazeBlock();
          console.log(`Making maze block`);
        }
      }
    }
  }

}
