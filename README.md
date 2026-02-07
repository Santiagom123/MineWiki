# MineWiki

## Compile

### Requirements

* Java JDK 8 (for Minecraft Forge 1.12.2)
* Gradle (or use the included Gradle Wrapper)
* Minecraft Forge MDK set up in the project

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/santiagom123/MineWiki.git
   cd MineWiki
   ```

2. Build the project:

   * Windows:

     ```bash
     gradlew build
     ```
   * Linux / macOS:

     ```bash
     ./gradlew build
     ```

3. The compiled `.jar` file will be generated in:

   ```
   /build/libs
   ```

---

## Contributing

Contributions are welcome through Pull Requests.

### Guidelines

* Fork the repository.
* Create a feature branch:

  ```bash
  git checkout -b feature-name
  ```
* Keep changes focused and well-structured.
* Follow existing code style and project structure.
* Provide clear commit messages.
* Test builds before submitting.

### Submitting

1. Push your branch:

   ```bash
   git push origin feature-name
   ```
2. Open a Pull Request describing:

   * What was added or changed
   * Why the change is needed
   * Any relevant context for review

By contributing, you agree that your code may be integrated into the project under its license terms.
