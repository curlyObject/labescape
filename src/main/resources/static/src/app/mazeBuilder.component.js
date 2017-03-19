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
var MazeBlock_1 = require('./MazeBlock.js');
var maze_service_1 = require('./maze.service.js');
var MazeBuilderComponent = (function () {
    function MazeBuilderComponent(mazeService) {
        this.mazeService = mazeService;
        this.mazeWidth = 0;
        this.mazeHeight = 0;
        this.solving = false;
    }
    MazeBuilderComponent.prototype.updateMazeSize = function (mazeHeight, mazeWidth) {
        this.maze = [];
        this.startX = undefined;
        this.startY = undefined;
        var i = 0;
        for (i; i < mazeHeight; i++) {
            if (!this.maze[i]) {
                this.maze[i] = [];
            }
            var j = 0;
            for (j; j < mazeWidth; j++) {
                if (!this.maze[i][j]) {
                    this.maze[i][j] = new MazeBlock_1.MazeBlock();
                }
            }
        }
    };
    MazeBuilderComponent.prototype.toggleBlockType = function (block) {
        block.toggleBlockType();
    };
    MazeBuilderComponent.prototype.solveMaze = function () {
        var _this = this;
        this.errorMessage = undefined;
        this.solving = true;
        this.mazeService.solveMaze(this.maze, this.startX, this.startY)
            .then(function (solvedMaze) {
            _this.maze = solvedMaze;
            _this.startX = undefined;
            _this.startY = undefined;
            _this.solving = false;
        })
            .catch(function (errorMessage) {
            _this.solving = false;
            _this.errorMessage = errorMessage;
        });
    };
    MazeBuilderComponent.prototype.allowDrop = function (ev, startX, startY) {
        if (!this.maze[startY][startX].isWall()) {
            ev.preventDefault();
        }
    };
    MazeBuilderComponent.prototype.setStartPosition = function (ev, startX, startY) {
        if (!this.maze[startY][startX].isWall()) {
            ev.preventDefault();
            if (this.startX && this.startY) {
                this.maze[this.startY][this.startX].toggleStartPosition();
            }
            this.startX = startX;
            this.startY = startY;
            this.maze[this.startY][this.startX].toggleStartPosition();
        }
    };
    MazeBuilderComponent = __decorate([
        core_1.Component({
            selector: 'maze-builder',
            templateUrl: "/src/app/MazeBuilder.html",
            styleUrls: ['/src/app/mazeBuilder.component.css'],
            providers: [maze_service_1.MazeService]
        }),
        __metadata('design:paramtypes', [maze_service_1.MazeService])
    ], MazeBuilderComponent);
    return MazeBuilderComponent;
}());
exports.MazeBuilderComponent = MazeBuilderComponent;
//# sourceMappingURL=mazeBuilder.component.js.map
