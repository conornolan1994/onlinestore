package io.conor.iterator;

import java.util.ArrayList;

import io.conor.model.User;

public class UserIterator implements Iterator<User> {
    
    private ArrayList<User> users = new ArrayList<User>();
    private int position;
     
    public UserIterator(ArrayList<User> users)
    {
        this.users = users;
        position = 0;
    }
 
    @Override
    public void reset() {
        position = 0;
    }
 
    @Override
    public User next() {
        return users.get(position++);
    }
 
    @Override
    public User currentItem() {
        return users.get(position);
    }
 
    @Override
    public boolean hasNext() {
        if(position >= users.size())
            return false;
        return true;
    }
}
