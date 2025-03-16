let now = new Date();
// Current time in GMT timezone
console.log(now);
// Current time in string format
console.log(now.toDateString());
// Extract year
console.log(now.getFullYear());
// Extract day if week
console.log(now.getDay());
// Day after tomorrow 
now.setDate(now.getDate() + 2)
console.log(now.toISOString())