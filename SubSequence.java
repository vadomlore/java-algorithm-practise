import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 动态规划计算最长递增子序列 使用链表的方式记录ArrayList中的节点位置 Created by zyl on 2017/7/12.
 */
public class SubSequence
{

    class Node
    {

        public int index;
        public int value;

        public Node(int index, int value)
        {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.format("index:%s value:%s", index, value);
        }
    }

    private ArrayList<Integer> seq = new ArrayList<>(Arrays.asList(1, 7, 2, 8, 3, 4));

    public ArrayList<LinkedList<Node>> init()
    {
        ArrayList<LinkedList<Node>> seqCollections = new ArrayList<>();
        for (int i = 0; i < this.seq.size(); i++)
        {
            LinkedList<Node> pitch = new LinkedList<>();
            Node node1 = new Node(i, this.seq.get(i));
            pitch.add(node1);
            seqCollections.add(pitch);
        }
        System.out.println(seqCollections);
        return seqCollections;
    }

    public ArrayList<LinkedList<Node>> IncreaseOne(ArrayList<LinkedList<Node>> nodeLists)
    {
        ArrayList<LinkedList<Node>> newCollections = new ArrayList<>();
        for (LinkedList<Node> smallCollection : nodeLists)
        {
            for (int i = smallCollection.getLast().index + 1; i < this.seq.size(); i++)
            {
                if (smallCollection.getLast().value < this.seq.get(i))
                {
                    LinkedList<Node> newSubSequence = new LinkedList<>();
                    smallCollection.forEach(e -> {
                        newSubSequence.add(e);
                    });
                    newSubSequence.add(new Node(i, this.seq.get(i)));
                    newCollections.add(newSubSequence);
                }
            }

        }
        System.out.println(newCollections);
        return newCollections;
    }

    public static void main(String[] args)
    {
        SubSequence seq = new SubSequence();
        ArrayList<LinkedList<Node>> nodes = seq.init();
        for (int i = 0; i < 4; i++)
        {
            nodes = seq.IncreaseOne(nodes);
        }
    }

}
