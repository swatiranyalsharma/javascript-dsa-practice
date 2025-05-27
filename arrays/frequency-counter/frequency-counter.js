//Write a function called same, which accepts two arrays. The function should return true if every value in the array has its corresponding value squared in the second array. The frequency of values must be the same. 
console.log('Result of Naive code');
console.log(same([1, 2, 3], [4, 1, 9])); // true
console.log(same([1, 2, 3], [1, 9])); // false
console.log(same([1, 2, 1], [4, 4, 1])); // false
console.log(same([1, 2, 3, 2], [9, 1, 4, 4])); // true
console.log(same([1, 2, 3, 2], [9, 1, 4, 4, 9])); // false
console.log('Result of refactored code');
console.log(same([1, 2, 3], [4, 1, 9])); // true
console.log(same([1, 2, 3], [1, 9])); // false
console.log(same([1, 2, 1], [4, 4, 1])); // false
console.log(same([1, 2, 3, 2], [9, 1, 4, 4])); // true
console.log(same([1, 2, 3, 2], [9, 1, 4, 4, 9])); // false
// Rephrase : input are two arrays : if each element in first array has its square in the second array, then return true, and order doesn't matters, also frequency must be same


// first naive method

function same(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }
    for (element of arr1) {
        // if(!(elements ** 2 in arr2)){|
        let index = arr2.indexOf(element ** 2)
        if (index === -1) {
            return false;
        }else{
            arr2.splice(index, 1);
        }
    }
    return true;
}




// Learnings:
//Use splice() when you want to change the array.(Adding, removing, or replacing elements in an array.)
// Use slice() when you want a safe copy of part of it. (Extracting a portion of an array without modifying the original.)


//optimized refactored code using frequency counter - here we will create object from array with their occurrence and then we will compare if square key exists in array 2 and occurrence of keys are equal or not

function same2(arr1, arr2){
    const freqCounter1= {};
    const freqCounter2= {};
    for(value of arr1){
        freqCounter1[value] = (freqCounter1[value] || 0) + 1;
    }
    for(value of arr2){
        freqCounter2[value] = (freqCounter2[value] || 0) + 1;
    }

    for(key in freqCounter1){
        if(!((key ** 2) in freqCounter2)){
            return false;
        }
        if(freqCounter1[key] !== freqCounter2[key]){
            return false;
        }
    }
    return true;
}