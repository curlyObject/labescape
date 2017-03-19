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
var http_1 = require('@angular/http');
require('rxjs/add/operator/toPromise');
var MazeBlock_1 = require('./MazeBlock.js');
var MazeService = (function () {
    function MazeService(http) {
        this.http = http;
    }
    MazeService.prototype.solveMaze = function (maze, startX, startY) {
        // const url = "http://localhost:8080/api/maze/solve?maze=O%20OOO%20%20OOO%20OOOOO&mazeWidth=4&startX=2&startY=1";
        var url = "http://localhost:8080/api/maze/solve?maze=" + this.convertMazeToString(maze) + "&mazeWidth=" + maze[0].length + "&startX=" + startX + "&startY=" + startY;
        console.log("Url " + url);
        return this.http.get(url)
            .toPromise()
            .then(function (response) {
            var mazeString = response.text();
            var i = 0;
            var solvedMaze = [];
            var mazeRows = mazeString.split("\n");
            for (i; i < maze.length; i++) {
                solvedMaze[i] = [];
                var j = 0;
                for (j; j < maze[i].length; j++) {
                    solvedMaze[i][j] = new MazeBlock_1.MazeBlock(mazeRows[i][j]);
                }
            }
            console.log(solvedMaze);
            return solvedMaze;
        })
            .catch(this.handleError);
    };
    MazeService.prototype.convertMazeToString = function (maze) {
        var mazeString = "";
        maze.forEach(function (row) { return row.forEach(function (block) { return mazeString += block.toString(); }); });
        return mazeString;
    };
    MazeService.prototype.handleError = function (error) {
        var errMsg;
        if (error instanceof http_1.Response) {
            var body = error.json() || '';
            var err = body.message || JSON.stringify(body);
            errMsg = "" + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Promise.reject(errMsg);
    };
    MazeService = __decorate([
        core_1.Injectable(),
        __metadata('design:paramtypes', [http_1.Http])
    ], MazeService);
    return MazeService;
}());
exports.MazeService = MazeService;
//# sourceMappingURL=maze.service.js.map
