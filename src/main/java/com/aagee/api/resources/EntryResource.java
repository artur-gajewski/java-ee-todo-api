package com.aagee.api.resources;

import com.aagee.api.dao.TodoDAO;
import com.aagee.api.models.Todo;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("entries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntryResource {

    @Inject
    TodoDAO todoDAO;

    @GET
    public Response getAll() {
        return Response.ok(todoDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Todo todo = todoDAO.findById(id);

        return Response.ok(todo).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Todo todo) {
        Todo updatedTodo = todoDAO.findById(id);

        updatedTodo.setTask(todo.getTask());
        updatedTodo.setDescription(todo.getDescription());
        todoDAO.update(updatedTodo);

        return Response.ok(updatedTodo).build();
    }

    @POST
    public Response create(Todo todo) {
        todoDAO.create(todo);
        return Response.ok(todo).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Todo todo = todoDAO.findById(id);

        todoDAO.delete(todo);

        return Response.ok().build();
    }

}