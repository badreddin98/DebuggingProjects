// Bug 1: Global variable pollution
function calculateTotal() {
    total = 0;  // Missing 'let' or 'const'
    for (let i = 0; i < items.length; i++) {
        total += items[i].price;
    }
    return total;
}

// Bug 2: Callback hell
function getUserData(userId) {
    fetch(`/api/users/${userId}`)
        .then(response => response.json())
        .then(user => {
            fetch(`/api/posts/${user.id}`)
                .then(response => response.json())
                .then(posts => {
                    fetch(`/api/comments/${posts[0].id}`)
                        .then(response => response.json())
                        .then(comments => {
                            console.log(comments);
                        });
                });
        });
}

// Bug 3: Improper error handling
function divide(a, b) {
    return a / b;  // No check for division by zero
}

// Bug 4: Memory leak
function createEventListener() {
    const button = document.getElementById('myButton');
    button.addEventListener('click', function() {
        console.log('Button clicked');
    });
    // Event listener is never removed
}

// Bug 5: Race condition
let data = null;
fetch('/api/data').then(response => response.json()).then(result => {
    data = result;
});
console.log(data);  // Will always be null

// Bug 6: Improper type checking
function processUser(user) {
    if (user.name) {  // Should check if user is an object first
        console.log(user.name);
    }
}

// Bug 7: Synchronous blocking code
function processLargeArray(array) {
    for (let i = 0; i < array.length; i++) {
        // Heavy computation
        array[i] = array[i] * 2;
    }
}

// Bug 8: Improper closure usage
function createCounter() {
    let count = 0;
    return {
        increment: function() {
            count++;
        },
        getCount: function() {
            return count;
        }
    };
}

// Bug 9: Improper promise handling
function fetchData() {
    fetch('/api/data')
        .then(response => response.json())
        .then(data => {
            return data;
        });  // Missing return statement
}

// Bug 10: Improper object mutation
const user = {
    name: 'John',
    age: 30
};
user.age = 31;  // Direct mutation of const object

// Example of correct JavaScript
class UserService {
    constructor() {
        this.baseUrl = '/api/users';
    }

    async getUserData(userId) {
        try {
            const response = await fetch(`${this.baseUrl}/${userId}`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error fetching user data:', error);
            throw error;
        }
    }

    async getUserPosts(userId) {
        try {
            const userData = await this.getUserData(userId);
            const response = await fetch(`${this.baseUrl}/${userData.id}/posts`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error fetching user posts:', error);
            throw error;
        }
    }
}

// Usage
const userService = new UserService();
userService.getUserPosts(123)
    .then(posts => console.log(posts))
    .catch(error => console.error(error)); 