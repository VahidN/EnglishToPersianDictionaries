using System.Collections.Generic;

namespace HowToLoadDictionaries.Models
{
    public class WordGroup
    {
        public string Group { set; get; }
        public int Entries => Words.Count;
        public HashSet<Word> Words { set; get; }

        public WordGroup()
        {
            Words = new HashSet<Word>();
        }

        public override string ToString()
        {
            return $"{Group}[{Words.Count.ToString()}]";
        }
    }
}