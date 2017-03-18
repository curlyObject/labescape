export class MazeBlock {
  type: string;

  private wall = "O";
  private start = "X";
  private path = "•";
  private empty = "_";


  constructor(type?: string) {
    this.type = type || this.wall;
  }

  toggleBlockType(){
    if (this.type === this.wall) {
      this.type = this.empty;
    }
    else if (this.type === this.empty) {
      this.type = this.wall;
    }
    else if (this.type === this.path) {
      this.type = this.empty;
    }
  }

  toggleStartPosition(){
    if (this.type === this.start){
      this.type = this.empty;
    }
    else if (this.type === this.empty){
      this.type = this.start;
    }
  }

  isWall(): boolean{
    return this.type === this.wall;
  }

  toString(): string{
    return this.isWall() ? this.wall : " ";
    // return this.isWall() ? this.wall : this.empty;
  }

}
