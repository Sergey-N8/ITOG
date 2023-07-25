import Note

# Создание заметки
def create_note(number):
    title = check_len_text_input(
        input('Введите Название заметки: '), number)
    body = check_len_text_input(
        input('Введите Описание заметки: '), number)
    return Note.Note(title=title, body=body)

# Меню, в бесконечном цикле до выбора 7 пункта
def menu():
    print("\nЭто программа 'Заметки'. Имеются следующие функции:\n\n1 - вывод всех заметок из файла\n2 - добавление заметки\n3 - удаление заметки\n4 - редактирование заметки\n5 - выборка заметок по дате\n6 - показать заметку по id\n7 - выход\n\nВведите номер функции: ")

# Проверка длинны текста, за длинну отвечает n, изменяется в function.py (namber)
def check_len_text_input(text, n):
    while len(text) <= n:
        print(f'Текст должен быть больше {n} символов\n')
        text = input('Введите тескт: ')
    else:
        return text

# При выборе 7 пункта программа завершается
def goodbuy():
    print("Приходите к нам еще =). До новых встреч!")
