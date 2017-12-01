import java.io.*;
import java.util.LinkedList;

/**
 * Created by apetrillo on 12/1/2017.
 */
public class Artist3Demo {

    public static void main(String[] args) throws IOException
    {
        //Build artist object linked list
        LinkedList<Artist> artistLinkedList = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("p1artists.txt"));
        String str;
        String[] piece = new String[2];
        while((str=bufferedReader.readLine())!=null)
        {
            for (int i = 0; i < 2; i++)
                piece = str.split("\t");
            artistLinkedList.add(new Artist(Integer.parseInt(piece[0]), piece[1]));
        }
        bufferedReader.close();
        //Finish building artist list


        //Build art object linked list
        LinkedList<Art> artLinkedList = new LinkedList<>();
        bufferedReader = new BufferedReader(new FileReader("p1arts.txt"));
        piece = new String[4];
        while((str=bufferedReader.readLine())!=null)
        {
            for (int i = 0; i < 4; i++)
                piece = str.split("\t");
            artLinkedList.add(new Art(Integer.parseInt(piece[0]), piece[1], Integer.parseInt(piece[2]), Integer.parseInt(piece[3])));
        }
        bufferedReader.close();
        //Finish building art list

        //Build p3artists_arts.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("p3artists_arts.txt"));
        bufferedWriter.write("Artist ID\tArtist Name\tArt ID\tArt Title\tAppraised Value\r\n");
        int tempID = -1;
        for (Artist artist : artistLinkedList)
        {
            for (Art art : artLinkedList)
            {
                if (artist.artistID == art.artistID)
                {
                    if (tempID != artist.artistID)
                    {
                        bufferedWriter.write(artist.artistID + "\t" +
                                artist.artistName + "\t" +
                                art.artID + "\t" +
                                art.artTitle + "\t" +
                                art.artValue + "\r\n");
                        tempID = artist.artistID;

                    }
                    else
                        bufferedWriter.write("\t" +
                                "\t" +
                                art.artID + "\t" +
                                art.artTitle + "\t" +
                                art.artValue + "\r\n");

                }
            }
        }
        bufferedWriter.close();
    }
}
