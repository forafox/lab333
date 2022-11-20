package task.persons;

public interface Friend {

    default void addFriend(Character x){//метод для добавления интерсов
    }

    default String getFriendList(){ //Получение списка друзей
        return "";
    }
}
