"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var MazeBlock = (function () {
    function MazeBlock() {
        this.type = "O";
    }
    return MazeBlock;
}());
exports.MazeBlock = MazeBlock;
var MazeBuilderComponent = (function () {
    function MazeBuilderComponent() {
        this.mazeWidth = 4;
        this.mazeHeight = 4;
        this.maze = [];
    }
    MazeBuilderComponent.prototype.updateMazeSize = function (mazeHeight, mazeWidth) {
        console.log("changing maze size...");
        var i = 0;
        console.log(i);
        console.log(mazeHeight);
        var j = 0;
        console.log(j);
        console.log(mazeWidth);
        for (i; i < mazeHeight; i++) {
            console.log("First loop");
            if (!this.maze[i]) {
                this.maze[i] = [];
            }
            for (j; j < mazeWidth; j++) {
                if (!this.maze[i][j]) {
                    this.maze[i][j] = new MazeBlock();
                    console.log("Making maze block");
                }
            }
        }
    };
    MazeBuilderComponent = __decorate([
        core_1.Component({
            selector: 'maze-builder',
            templateUrl: "/app/MazeBuilder.html",
        }), 
        __metadata('design:paramtypes', [])
    ], MazeBuilderComponent);
    return MazeBuilderComponent;
}());
exports.MazeBuilderComponent = MazeBuilderComponent;
//# sourceMappingURL=mazeBuilder.component.js.map