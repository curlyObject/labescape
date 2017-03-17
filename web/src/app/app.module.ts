import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MazeBuilderComponent }  from './mazeBuilder.component';
import { MazeBlockComponent }  from './mazeBlock.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  imports:      [ BrowserModule,
                  FormsModule],
  declarations: [ MazeBuilderComponent,
                  MazeBlockComponent],
  bootstrap:    [ MazeBuilderComponent ]
})
export class AppModule { }
