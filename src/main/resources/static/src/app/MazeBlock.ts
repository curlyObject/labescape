export class MazeBlock {
  type: string;

  private wall = "O";
  private start = "X";
  private path = "•";
  private empty = " ";


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
    else if (this.type === this.empty || this.isPath()){
      this.type = this.start;
    }
  }

  isWall(): boolean{
    return this.type === this.wall;
  }

  isStart(): boolean{
    return this.type === this.start;
  }

  isEmpty(): boolean{
    return this.type === this.empty;
  }

  isPath(): boolean{
    return this.type === this.path;
  }

  toString(): string{
    return this.isWall() ? this.wall : this.empty;
  }

}
