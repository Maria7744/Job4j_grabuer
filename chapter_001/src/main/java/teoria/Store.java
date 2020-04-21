package teoria;
import java.util.List;
import java.util.function.Predicate;
//Интерфейс позволяют избавиться от прямо
// зависимости. На первом этапе можно использовать MemStore - хранения данных в памяти.
//
//Метод save - сохраняет объявление в базе.
//
//Метод get - позволяет извлечь объявление из базы.
public interface Store {
    void save(Post post);

    List<Post> get(Predicate<Post> filter);
}

