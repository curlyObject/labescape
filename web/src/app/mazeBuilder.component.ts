import { Component } from '@angular/core';

export class MazeBlock {
  xPosition: number;
  yPosition: number;
  type: string;

  constructor() {
    this.type = "O";
  }

  toggleBlockType(){
    console.log(`Toggle type`);
    if (this.type === "O") {
      console.log(`Removing wall`);
      this.type = "_";
    }
    else if (this.type === "_") {
      console.log(`adding wall`);
      this.type = "O";
    }
  }

}

@Component({
  selector: 'maze-builder',
  templateUrl: `/app/MazeBuilder.html`,
})
export class MazeBuilderComponent  {
  mazeWidth = 4;
  mazeHeight = 4;

  maze: MazeBlock[][];

  updateMazeSize(mazeHeight: number, mazeWidth: number): void {
    console.log(`changing maze size...`);
    this.maze = [];
    let i: number = 0;
    for (i; i < mazeHeight; i++){
      if (!this.maze[i]){
        this.maze[i] = [];
      }
      let j: number = 0;
      for (j; j < mazeWidth; j++){
        if (!this.maze[i][j]){
          this.maze[i][j] = new MazeBlock();
        }
      }
    }
  }

  toggleBlockType(block: MazeBlock){
    block.toggleBlockType();
    console.log(this.maze);
  }

}
