package stacktop.swanand.com.stacktop;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {


    private final Context context;
    private List<Item> items=new ArrayList<>();


    private Picasso picasso;

    public PostAdapter(Context context,Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }
    public void addPosts(List<Item> items)
    {
        this.items=items;
    }


    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        PostViewHolder holder=new PostViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.post_title.setText(items.get(position).getTitle());
        holder.timestamp.setText(android.text.format.DateFormat.format("dd-MM-yyyy hh:mm:ss", items.get(position).getCreationDate()*1000L ));
        picasso.load(items.get(position).getOwner().getProfileImage()).into(holder.profile_image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder{

        public TextView post_title,timestamp;
        public ImageView profile_image;


        public PostViewHolder(View itemView) {
            super(itemView);

            this.post_title=itemView.findViewById(R.id.post_title);
            this.profile_image=itemView.findViewById(R.id.profile_image);
            this.timestamp=itemView.findViewById(R.id.timestamp);
        }
    }
}
