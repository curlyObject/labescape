import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';

import { MazeBuilderComponent }  from './mazeBuilder.component';
import {FormsModule} from "@angular/forms";
import {MazeService} from "./maze.service";

@NgModule({
  imports:      [ BrowserModule,
                  HttpModule,
                  FormsModule],
  declarations: [ MazeBuilderComponent],
  providers:    [ MazeService ],
  bootstrap:    [ MazeBuilderComponent ]
})
export class AppModule { }
