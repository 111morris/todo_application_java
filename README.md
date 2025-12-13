# 📝 Java To-Do List Application
A simple, stylish desktop To-Do List app built with Java Swing. This application lets users add, strike through (mark as done), and delete tasks in an intuitive GUI. It also demonstrates core Swing concepts like custom component panels, layout management, and action handling.

---
## 💡 Features
- Add new tasks with a click.
- Mark tasks as completed using a checkbox (adds strikethrough).
- Remove tasks instantly with a delete button.
- Scrollable task list for easy navigation.
- Custom font support for a personalized UI.
---
## 📁 Project Structure

```plaintext
src/
├── Main.java               # Application entry point
├── ToDoListGui.java        # Main GUI window logic and layout
├── Task
```
---
# Cloning the repository
```commandline
git clone https://github.com/your-username/java-todo-list-app.git
cd java-todo-list-app
```

# Compile and run
- from the root project directory:
```commandline
javac -d out -sourcepath src src/Main.java
java -cp out Main
```

---

## 🔧 Future Improvements

Here are some enhancements planned for future versions of the app:

- 💾 **Task Persistence**: Save and load tasks between sessions using a local file.
- ✅ **Input Validation**: Prevent adding empty or whitespace-only tasks.
- 🎨 **Responsive UI**: Replace fixed layout with layout managers for better resizing and scaling.
- 🌙 **Dark Mode / Themes**: Let users choose between different UI themes.
- 🌍 **Internationalization**: Support multiple languages using `ResourceBundle`.
- 🧪 **Unit Testing**: Add automated tests using JUnit to ensure code quality.
- 📦 **Font Fallback**: Handle missing or invalid font files more gracefully.
