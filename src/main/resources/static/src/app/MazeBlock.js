"use strict";
var MazeBlock = (function () {
    function MazeBlock(type) {
        this.wall = "O";
        this.start = "X";
        this.path = "•";
        this.empty = " ";
        this.type = type || this.wall;
    }
    MazeBlock.prototype.toggleBlockType = function () {
        if (this.type === this.wall) {
            this.type = this.empty;
        }
        else if (this.type === this.empty) {
            this.type = this.wall;
        }
        else if (this.type === this.path) {
            this.type = this.empty;
        }
    };
    MazeBlock.prototype.toggleStartPosition = function () {
        if (this.type === this.start) {
            this.type = this.empty;
        }
        else if (this.type === this.empty || this.isPath()) {
            this.type = this.start;
        }
    };
    MazeBlock.prototype.isWall = function () {
        return this.type === this.wall;
    };
    MazeBlock.prototype.isStart = function () {
        return this.type === this.start;
    };
    MazeBlock.prototype.isEmpty = function () {
        return this.type === this.empty;
    };
    MazeBlock.prototype.isPath = function () {
        return this.type === this.path;
    };
    MazeBlock.prototype.toString = function () {
        return this.isWall() ? this.wall : this.empty;
    };
    return MazeBlock;
}());
exports.MazeBlock = MazeBlock;
//# sourceMappingURL=MazeBlock.js.map