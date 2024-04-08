# Team project assignment

## Assessment criteria
1. **Proposal** should include a short description of your task, possible ways to solve it and team members. All the teams should have up to four students. At this stage, you also should describe the way you get your data. It is the result of this assignment.

2. **Final presentation** will be in June and should describe all stages of your project. Don't be afraid to fail in achieving SOTA scores in your task, don't be afraid to experiment. If you fail, explore why it happened. This can be an interesting experience for all of us.
Don't forget to provide links to papers and code you use. Put your code on GitHub and provide links to it.
Think about proper ways to present your results (if you generate music — play this music, if you compare techniques — provide tables with scores).
 
3. Describe stages of your work in a presentation and individual contribution of each team member.

## Possible course project themes 
0. It is a better strategy to come up with something that is interesting for you.
1. Apply GAN-like model to generate new Pokémon or some other characters of a similar kind. The problem with Pokémon is that there are not so many pictures of them in existing datasets. You can experiment with a combination of GAN and VAE. We would also advise you to try data augmentation techniques. Another approach is to play with the Stable Diffusion model or some other text-to-image model to augment data.
2. Build some neural network model (CNN or RNN or may be Transformer) to reconstruct LaTeX formulae from the picture of the formula. This task illustrates the situation when training examples can be easily generated.
3. Take pretrained Transformer model (GPT, BERT) and apply it to some of the downstream tasks like named entity recognition, question answering, and relation extraction.

There are lots of pretrained models on [Huggingface Transformers](https://github.com/huggingface/transformers)

4. Apply boosting method for ResNet training (layer-wise training for deep models).

Try to implement ideas from the paper [Learning Deep ResNet Blocks Sequentially using Boosting Theory](https://arxiv.org/abs/1706.04964)
The paper describes the author's ideas of boosting method and how to apply boosting to ResNet training.

5. Experiment with a style transfer for pictures (or maybe music or texts).

6. Implement a web interface to learn playing some game. Look at the [Connect4-Gamesolver](https://connect4.gamesolver.org/) as a reference.

7. Here may be an interesting project from you, in essence, and volume similar to those described above. It can be proposed and agreed with the course teachers, that everything is achievable.

   
## Some general hints and tips for a course project
1. Find the data you want to work with. Take into account what are the licences of these datasets. Is this dataset big, balanced, diverse? Does it need preprocessing? How big the model should be (model first performs memorisation and then generalisation, so for big and diverse examples we need big model)? How well train and test subsets are split? 

2. Take suitable model for you task. Read papers, look into codebase (this means, prefer those papers which come accompanied by code), ask ChatGPT. Look for papers on [ArXiv Sanity Preserver](http://www.arxiv-sanity.com), [NLP-Progress](http://nlpprogress.com) or [Papers with Code](https://paperswithcode.com). It is a good strategy to take pretrained model for your task. Search pretrained transformer models on [Huggingface Transformers](https://github.com/huggingface/transformers).

3. What kind of task are you going to solve: classification (most of the real-life tasks), regression, clusterization, generative (generate pictures, music or texts), reinforcement learning? What is your loss function? What kind of regularisation is applicable in your task? What are the metrics in your task (keep in mind that automatic metrics for text or music are just correlated with human preference)?

4. Implement your baseline algorithm (this can be some ML or statistical algorithm) for your task.

5. Implement your main algorithm (from a chosen paper, for example). Make sure that your model can be trained to the highest values of a chosen metric on a small portion of a train set (just to be sure there are no mistakes in the implementation).
If everything is fine, apply some additional techniques (regularisation, dropout, optimisation tricks) to achieve better scores on a dev set while training on a whole dataset.

6. Explore the influence of parameters on a training process speed (learning rate, batch size, optimizer). 
