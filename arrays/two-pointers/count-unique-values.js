//Write a function called countUniqueValues, which accepts a sorted array, and counts the unique values in the array. There can be negative numbers in the array, but it will always be sorted. 


//method1
function countUniqueValues(arr){
    const mySet = new Set();
    for(val of arr){
        mySet.add(val);
    }
    return mySet.size;
}

//method2
function countUniqueValues(arr){
    const newArr = [];
    for(val of arr){
        if(!newArr.includes(val)){
            newArr.push(val);
        }
    }
    return newArr.length;
}

//method3
function countUniqueValues(arr){
    const frequencyCounter = {};
    for(val of arr){
        frequencyCounter[val] = (frequencyCounter[val] || 0) + 1;
    }
    return Object.keys(frequencyCounter).length;
}

//method4
function countUniqueValues(arr){
    let left = 0;
    let right = 1;
    while(right<arr.length){
        if(arr[left] !== arr[right]){
            left++;
            arr[left] = arr[right];
        }
        right++;
    }
    return left+1;
}

console.log(countUniqueValues([1,1,1,1,2]));
console.log(countUniqueValues([1,2,3,4,4,4,7,7,12,12,13]));
console.log(countUniqueValues([]));