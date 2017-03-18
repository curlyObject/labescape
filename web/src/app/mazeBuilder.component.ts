import { Component } from '@angular/core';

import { MazeBlock } from './MazeBlock';
import { MazeService } from './maze.service';

@Component({
  selector: 'maze-builder',
  templateUrl: `/app/MazeBuilder.html`,
  styleUrls: [ 'app/mazeBuilder.component.css' ],
  providers: [MazeService]
})

export class MazeBuilderComponent  {
  mazeWidth = 0;
  mazeHeight = 0;

  startX: number;
  startY: number;

  maze: MazeBlock[][];

  constructor(private mazeService: MazeService) { }

  updateMazeSize(mazeHeight: number, mazeWidth: number): void {
    this.maze = [];
    this.startX = undefined;
    this.startY = undefined;
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
  }

  solveMaze(){
    this.mazeService.solveMaze(this.maze, this.startX, this.startY)
      .then((solvedMaze) => this.maze = solvedMaze);
  }

  allowDrop(ev : Event, startX: number, startY: number){
    if (!this.maze[startY][startX].isWall()) {
      ev.preventDefault();
    }
  }

  setStartPosition(ev : Event, startX: number, startY: number){
    console.log("Set Start position");
    if (!this.maze[startY][startX].isWall()) {
      ev.preventDefault();
      if (this.startX && this.startY){
        this.maze[this.startY][this.startX].toggleStartPosition();
      }
      this.startX = startX;
      this.startY = startY;
      this.maze[this.startY][this.startX].toggleStartPosition();
    }
  }

}
