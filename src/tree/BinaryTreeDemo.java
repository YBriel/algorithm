package tree;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/10   14:03
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode = new HeroNode(1, "tom");
        HeroNode heroNode2 = new HeroNode(2, "jerry");
        HeroNode heroNode3 = new HeroNode(3, "anna");
        HeroNode heroNode4 = new HeroNode(4, "peter");

        heroNode.setLeft(heroNode2);
        heroNode.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        binaryTree.setHeroNode(heroNode);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.midOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public void setHeroNode(HeroNode heroNode) {
        this.root = heroNode;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("链表为空...");
        }
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("链表为空...");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("链表为空...");
        }
    }
}

class HeroNode {
    private int num;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序
    public void midOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序
    public void postOrder() {
        //递归向左子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
        if (this.left != null) {
            this.left.preOrder();
        }
        System.out.println(this);

    }

    //前序搜索
    public HeroNode preSearch(int num) {
        if (this.num == num) {
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preSearch(num);
        }
        return resNode;
    }

    public HeroNode midSearch(int num) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.num == num) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.preSearch(num);
        }
        return resNode;
    }

    public HeroNode postSearch(int num) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.num == num) {
            return this;
        }
        return null;
    }
}
