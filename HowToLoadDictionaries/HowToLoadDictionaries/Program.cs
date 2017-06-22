using System.IO;
using HowToLoadDictionaries.Core;
using HowToLoadDictionaries.Models;

namespace HowToLoadDictionaries
{
    class Program
    {
        static void Main(string[] args)
        {
            foreach (var dir in Directory.GetDirectories(@"..\..\..\..\Dictionaries"))
            {
                foreach (var filePath in Directory.GetFiles(dir, "*.json"))
                {
                    var currentFileWordGroup = JsonHelper.DeserializeFromFile<WordGroup>(filePath);
                    foreach (var word in currentFileWordGroup.Words)
                    {
                        foreach (var meaninig in word.Meanings)
                        {
                            //...
                        }
                    }
                }
            }
        }
    }
}