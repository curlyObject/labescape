import { Component } from '@angular/core';

export class MazeBlock {
  xPosition: number;
  yPosition: number;
  type: string;
}

@Component({
  selector: 'maze-block',
  templateUrl: `/app/MazeBlock.html`,
})
export class MazeBlockComponent  {
  block: MazeBlock = {
    xPosition: 0,
    yPosition: 0,
    type: "O"
  };
}
