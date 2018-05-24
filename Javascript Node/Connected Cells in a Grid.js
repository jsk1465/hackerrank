'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the connectedCell function below.
function connectedCell(matrix) {
    var max = 0;
    for(var x = 0; x<matrix.length; x++){
        for(var y = 0; y<matrix[0].length;y++){
            if(matrix[x][y]==1){
                console.log("found one");
                var cur = checkCells(matrix,x,y,0);
                if(cur>max)
                    max = cur;
                console.log(matrix);
            }
            console.log(x + " " + y)
        }
    }
    return max;
}

function checkCells(matrix,x,y,count){
    console.log("inside new checkCells at " + x + " " + y);
    console.log("size of matrix " + matrix.length + " " + matrix[0].length);
    //console.log(matrix);
    //if out of range
    if(x>=matrix.length || y >= matrix[0].length)
        return count;
    if(x<0 || y < 0)
        return count;
    //if it's invalid continue;
    if(matrix[x][y] == 0)
        return count;
    count++;
    matrix[x][y] = 0;
    //check left-right AND up-down;
    var differenceMatrix = [-1,0,1];
    for(var i = 0; i < 3; i++){
        var nextX = x + differenceMatrix[i];
        for(var j = 0; j < 3; j++){
            var nextY = y + differenceMatrix[j];
            if(nextX>=matrix.length || nextY >= matrix[0].length)
                continue;
            else if(nextX<0 || nextY < 0)
                continue;
            else if(matrix[nextX][nextY] == 0)
                continue;
            count = checkCells(matrix,nextX,nextY,count);
        }
     }
    return count;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const m = parseInt(readLine(), 10);

    let matrix = Array(n);

    for (let i = 0; i < n; i++) {
        matrix[i] = readLine().split(' ').map(matrixTemp => parseInt(matrixTemp, 10));
    }

    let result = connectedCell(matrix);

    ws.write(result + "\n");

    ws.end();
}
