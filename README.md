# Teaching Resources

A collection of debugging exercises and learning resources for software development concepts.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher
- Maven 3.6 or higher
- Git
- An IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)
- GitHub account

### Forking the Repository

1. Go to the [Teaching Resources repository](https://github.com/yourusername/TeachingResources)
2. Click the "Fork" button in the top-right corner
3. Select your GitHub account as the destination

### Cloning Your Fork

1. Open your terminal or command prompt
2. Navigate to where you want to clone the repository
3. Run the following command, replacing `YOUR_USERNAME` with your GitHub username:
   ```bash
   git clone https://github.com/YOUR_USERNAME/TeachingResources.git
   ```
4. Navigate into the project directory:
   ```bash
   cd TeachingResources
   ```

### Setting Up the Project

1. Open the project in your preferred IDE
2. Let the IDE import the Maven project and download dependencies
3. Build the project:
   ```bash
   mvn clean install
   ```

## Project Structure

The repository contains several debugging exercises organized by topic:

### Memory Management
- Location: `MemoryManagement/memory-management-debugging/`
- Focus: Heap vs Stack, Memory leaks, Reference types, Garbage collection
- [Detailed README](MemoryManagement/memory-management-debugging/README.md)

### SOLID Principles
- Location: `SOLID/`
- Focus: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
- [Detailed README](SOLID/README.md)

### Object-Oriented Programming
- Location: `OOP/`
- Focus: Encapsulation, Inheritance, Polymorphism, Abstraction, Composition
- [Detailed README](OOP/README.md)

### Design Patterns
- Location: `DesignPatterns/`
- Focus: Creational, Structural, and Behavioral patterns
- [Detailed README](DesignPatterns/README.md)

## Working with Exercises

1. Each exercise contains:
   - A main class with broken scenarios
   - A test class to verify fixes
   - A detailed README with explanations

2. To work on an exercise:
   - Read the exercise's README
   - Run the tests to see them fail
   - Fix the issues one at a time
   - Verify your fixes by running the tests

## Contributing

1. Create a new branch for your changes:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. Make your changes and commit them:
   ```bash
   git add .
   git commit -m "Description of your changes"
   ```

3. Push your changes to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```

4. Create a Pull Request from your fork to the main repository

## Keeping Your Fork Updated

1. Add the original repository as a remote:
   ```bash
   git remote add upstream https://github.com/original-owner/TeachingResources.git
   ```

2. Fetch updates from the original repository:
   ```bash
   git fetch upstream
   ```

3. Merge updates into your main branch:
   ```bash
   git checkout main
   git merge upstream/main
   ```

## Resources

- [Java Documentation](https://docs.oracle.com/en/java/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Git Documentation](https://git-scm.com/doc)
- [GitHub Guides](https://guides.github.com/)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you encounter any issues or have questions:
1. Check the exercise's README for specific instructions
2. Look for similar issues in the repository
3. Create a new issue with a detailed description of your problem

## Acknowledgments

- Thanks to all contributors who have helped improve these exercises
- Special thanks to the Java community for their excellent documentation and resources 